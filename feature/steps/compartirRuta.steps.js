import 'jest'
import { defineFeature, loadFeature } from 'jest-cucumber';

const feature = loadFeature('./feature/features/compartirRuta.feature');
const puppeteer = require('puppeteer');
let browser = null;
let page = null;

defineFeature(feature, test => {

    beforeEach(async () => {
        jest.setTimeout(12000000);
    });

    test("Un usuario quiere compartir una de sus rutas con uno de sus amigos", ({given, when, and, then}) => {
        given("Un usuario con una ruta creada", async() => {

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

        when("Voy a la lista de amigos", async() => {

            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("a")];
                botones.forEach(function(boton) {
                    if (boton.innerText === "Amigos") {
                        boton.click();
                    }
                })
            });

        });

        and("Selecciono una ruta", async() => {

            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("a")];
                botones.forEach(function(boton) {
                    if (boton.innerText === "Oviedo-Gijon") {
                        boton.click();
                    }
                })
            });

        });

        then("Le da a compartir con un amigo", async() => {

            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("a")];
                botones.forEach(function(boton) {
                    if (boton.innerText === "Compartir Oviedo-Gijon con este usuario") {
                        boton.click();
                    }
                })
            });

        });

    })



















});