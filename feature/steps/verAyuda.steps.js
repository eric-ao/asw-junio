import 'jest'
import { defineFeature, loadFeature } from 'jest-cucumber';

const feature = loadFeature('./feature/features/verAyuda.feature');
const puppeteer = require('puppeteer');
let browser = null;
let page = null;

defineFeature(feature, test => {

    beforeEach(async () => {
        jest.setTimeout(12000000);
    });

    test("Se encuentra con la sesión iniciada en la página principal", ({given, when, then}) => {
        given("Un usuario que quiere ver la pestaña de ayuda", async() => {

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

        when("Le hago click a Ayuda en la barra de navegación superior", async() => {

            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("a")];
                botones.forEach(function(boton) {
                    if (boton.innerText === "Ayuda") {
                        boton.click();
                    }
                })
            });

        });

        then("Se carga la pestaña de Ayuda", async () => {

            expect(page.url()).toBe("http://localhost:3000/asw-junio/ayuda")

        })
    })



















});