import 'jest'
import { defineFeature, loadFeature } from 'jest-cucumber';

const feature = loadFeature('./feature/features/verDetallesRuta.feature');
const puppeteer = require('puppeteer');
let browser = null;
let page = null;

defineFeature(feature, test => {

    beforeEach(async () => {
        jest.setTimeout(12000000);
    });

    test("Quiero ver los detalles de una de mis rutas", ({given, when, and, then}) => {
        given("Un usuario que quiere ver los detalles de una de sus rutas creadas", async() => {

            browser = await puppeteer.launch({
                headless: false
            });

            page = await browser.newPage();
            await page.goto("http://localhost:3000/asw-junio/welcome", {
                waitUntil: 'load',
                timeout: 0
            });

            await page.waitForSelector(".sc-EHOje.cffgrt");
            await page.type(".sc-EHOje.cffgrt", "https://uo258623.solid.community/profile/card#me");

            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("button")];
                botones.forEach(function(boton) {
                    if (boton.innerText === "Iniciar sesión") {
                        boton.click();
                    }
                })
            });

            await page.waitForNavigation({
                waitUntil: "networkidle2"
            });

            await page.waitForSelector("[id='username']", { visible: true });
            await page.type("[id='username']", "uo258623");

            await page.waitFor(500);

            await page.waitForSelector("[id='password']", { visible: true });
            await page.type("[id='password']", "viade_es4b", { visible: true });

            await page.waitFor(500);

            await page.evaluate(() => {
                let btns = [ ...document.querySelector(".form-horizontal.login-up-form").querySelectorAll("button") ];
                btns.forEach(function(btn) {
                    if (btn.innerText === "Log In") {
                        btn.click();
                    }
                });
            });

            await page.waitForNavigation({
                waitUntil: "networkidle2"
            });

            expect(page.url()).toBe("http://localhost:3000/asw-junio/#");

        });

        when("Voy a la pestaña del mapa", async() => {

            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("a")];
                botones.forEach(function(boton) {
                    if (boton.innerText === "Mapa") {
                        boton.click();
                    }
                })
            });

            await page.waitFor(500);
            await page.waitForSelector("p", {visible:false})
        });

        and("Hago click sobre una de mis rutas", async () => {

            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("button")];
                botones.forEach(function(boton) {
                    if (boton.innerText === "Ruta") {
                        boton.click();
                    }
                })
            });

        });

        then("Se muestra la ruta y sus descripción", async() => {

            await page.waitFor(500);
            await page.waitForSelector("p", {visible:true})
            //Comprobamos sencillamente que hay un elemento <p> visible porque es el tipo de elemento de
            //las descripciones. Antes de haberle dado a la ruta para mostrar la ruta hicimos una prueba similar,
            //pero probando que NO hay ningun <p> visible, esto es porque el unico elemento <p> en esta página es el
            //de la descripción.
        })
    })

});