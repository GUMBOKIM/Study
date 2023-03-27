describe("계산기 어플리케이션 테스트", () => {
    beforeEach(() => {
        cy.visit("http://localhost:63342/Study/FrontEnd/Cypress/js-calculator-test-cypress/index.html?_ijt=s9tjd0uf79r81ek3hh5orbb9me&_ij_reload=RELOAD_ON_SAVE");
    });

    it("2개의 숫자에 대해서 덧셈이 가능하다.", () => {
        cy.get(".digit").contains("2").click();
        cy.get(".operation").contains("+").click();
        cy.get(".digit").contains("1").click();
        cy.get(".operation").contains("=").click();
        cy.get("#total").should("have.text", "3");
    })
})