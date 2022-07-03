import {fireEvent, render, screen} from '@testing-library/react';
import App from './App';

describe("button app", () => {
  describe("layer", () => {
    test('the counter starts at 0', () => {
      render(<App/>);
      const counterElement = screen.getByTestId("counter");
      expect(counterElement).toHaveTextContent(0);
    })

    test('minus button has correct text', () => {
      render(<App/>);
      const minusButtonElement = screen.getByTestId("minus-button");
      expect(minusButtonElement).toHaveTextContent("-");
    })

    test('plus button has correct text', () => {
      render(<App/>);
      const minusButtonElement = screen.getByTestId("plus-button");
      expect(minusButtonElement).toHaveTextContent("+");
    })

    test('When the + button is pressed, the counter changes to 1', () => {
      render(<App/>);
      const buttonElement = screen.getByTestId("plus-button");
      fireEvent.click(buttonElement);
      const counterElement = screen.getByTestId("counter");
      expect(counterElement).toHaveTextContent('1');
    })

    test('When the - button is pressed, the counter changes to -1', () => {
      render(<App/>);
      const buttonElement = screen.getByTestId("minus-button");
      fireEvent.click(buttonElement);
      const counterElement = screen.getByTestId("counter");
      expect(counterElement).toHaveTextContent('-1');
    })

    test('on/off button has blue color', () => {
      render(<App/>);
      const buttonElement = screen.getByTestId('on/off-button');
      expect(buttonElement).toHaveStyle({backgroundColor: 'blue'});
    })

    test('on/off button is pressed, the counter button is disabled', () => {
      render(<App/>);
      const buttonElement = screen.getByTestId('on/off-button');
      fireEvent.click(buttonElement);
      const plusButton = screen.getByTestId("plus-button");
      const minusButton = screen.getByTestId("minus-button");
      expect(plusButton).toBeDisabled();
      expect(minusButton).toBeDisabled();
    })


    test('testasdasd', () => {
      render(<App/>);
      const buttonElement = screen.getByTestId('on/off-button');
      fireEvent.click(buttonElement);
      const plusButton = screen.getByTestId("plus-button");
      expect(plusButton).toBeDisabled();
      fireEvent.click(buttonElement);
      expect(plusButton).toBeEnabled();
    })
  })
})
