import 'jest'
import { defineFeature, loadFeature } from 'jest-cucumber';

const feature = loadFeature('./feature/features/crearRuta.feature');
const puppeteer = require('puppeteer');
let browser = null;
let page = null;

defineFeature(feature, test => {

    beforeEach(async () => {
        jest.setTimeout(12000000);
    });

    test("Un usuario quiere crear una nueva ruta", ({given, when, and, then}) => {
        given("Un usuario que quiere crear una nueva ruta", async() => {

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

        });

        and("Hago click sobre el mapa para añadir dos puntos", async() => {

            await page.mouse.move(500, 500);
            await page.mouse.down({ button: "left" });
            await page.mouse.up({ button: "left" });
            await page.waitFor(1000);
            await page.mouse.move(520, 500);
            await page.mouse.down({ button: "left" });
            await page.mouse.up({ button: "left" });



        });

        and("Relleno el formulario de la ruta", async() => {

            await page.waitForSelector("[id='inputNombre']", { visible: true });
            await page.type("[id='inputNombre']", "Ruta testing");

            await page.waitForSelector("[id='inputDescripcion']", { visible: true });
            await page.type("[id='inputDescripcion']", "Esto es una ruta de prueba");

            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("Dropdown-placeholder")];
                botones.forEach(function(boton) {
                    if (boton.innerText === "Seleccione una...") {
                        boton.click();
                    }
                })
            });

            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("Dropdown-option")];
                botones.forEach(function(boton) {
                    if (boton.innerText === "Ciudad") {
                        boton.click();
                    }
                })
            });

        });

        then("Se guarda la ruta correctamente y aparece en mi lista de rutas.", async() => {


            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("boton")];
                botones.forEach(function(boton) {
                    if (boton.innerText === "Guardar ruta") {
                        boton.click();
                    }
                })
            });

            await page.waitFor(500);

            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("boton")];
                botones.forEach(function(boton) {
                    if (boton.innerText === "Ruta testing") {
                        boton.click();
                    }
                })
            });

            await page.waitFor(500);
            await page.waitForSelector("p", {visible:true})

        });

    })

});