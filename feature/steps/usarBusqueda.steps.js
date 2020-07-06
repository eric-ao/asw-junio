import 'jest'
import { defineFeature, loadFeature } from 'jest-cucumber';

const feature = loadFeature('./feature/features/usarBusqueda.feature');
const puppeteer = require('puppeteer');
let browser = null;
let page = null;

defineFeature(feature, test => {

    beforeEach(async () => {
        jest.setTimeout(12000000);
    });

    test("Búsqueda por categoría", ({given, when, and, then}) => {
        given("Un usuario que quiere filtrar por categoría", async() => {

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

        and("Hace click en la categoría de busqueda y en buscar", async() => {

            await page.waitFor(500);

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

            await page.evaluate(() => {
                let categoriaB = document.getElementById("botonB");
                categoriaB.click();
            });

        });

        then("Se muestra las rutas correspondientes", async() => {

            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("boton")];
                botones.forEach(function(boton) {
                    if (boton.innerText === "Ciudad") {
                        boton.click();
                    }
                })
            });

            await page.waitFor(500);
            await page.waitForSelector("p", {visible:true})

        });

    })



    test("Búsqueda por nombre", ({given, when, and, then}) => {
        given("Un usuario que quiere filtrar por nombre", async() => {

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

        and("Introduce el nombre y da a buscar", async() => {

            await page.waitFor(500);

            await page.waitForSelector("[id='textoB']", { visible: true });
            await page.type("[id='textoB']", "Ciudad");

            await page.evaluate(() => {
                let categoriaB = document.getElementById("botonB");
                categoriaB.click();
            });

        });

        then("Se muestra las rutas correspondientes", async() => {

            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("boton")];
                botones.forEach(function(boton) {
                    if (boton.innerText === "Ciudad") {
                        boton.click();
                    }
                })
            });

            await page.waitFor(500);
            await page.waitForSelector("p", {visible:true})

        });

    })

});