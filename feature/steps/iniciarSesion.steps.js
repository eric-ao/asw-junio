import 'jest'
import { defineFeature, loadFeature } from 'jest-cucumber';

const feature = loadFeature('./feature/features/iniciarSesion.feature');
const puppeteer = require('puppeteer');
let browser = null;
let page = null;

defineFeature(feature, test => {

    beforeEach(async () => {
        jest.setTimeout(12000000);
    });

    test("Un usuario ya registrado quiere iniciar sesión en la aplicación", ({given, when, and, then}) => {
        given("Un usuario que ya tiene cuenta registrada", async() => {

            browser = await puppeteer.launch({
                headless: false
            });

            page = await browser.newPage();
            await page.goto("http://localhost:3000/asw-junio/login", {
                waitUntil: 'load',
                timeout: 0
            });

        });

        when("Relleno el formulario con mi webid", async() => {

            await page.waitForSelector(".sc-EHOje.cffgrt");
            await page.type(".sc-EHOje.cffgrt", "https://uo258623.solid.community/profile/card#me");

            await page.evaluate(() => {
                let botones = [...document.querySelectorAll("button")];
                botones.forEach(function (boton) {
                    if (boton.innerText === "Iniciar sesión") {
                        boton.click();
                    }
                })
            });
        });

        and("Relleno el formulario en la página de Solid con mi usuario y contraseña", async() => {

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

        });

        then("Inicio sesión y voy a inicio", async () => {

            await page.waitForNavigation({
                waitUntil: "networkidle2"
            });

            expect(page.url()).toBe("http://localhost:3000/asw-junio/#");

        })
    })



















});