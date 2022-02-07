import React from "react";
import {mount, render, shallow} from "enzyme";
import {Button} from "../components/atom/Button";
import {Input} from "../components/atom/Input";
import {Icon} from "../components/atom/Icon";
import {Calculation} from "../components/service/operation";


describe("Render elements", () => {
    it("testing button", () => {
        render(<Button/>)
    });
    it("testing input", () => {
        render(<Input/>)
    });
    it('testing icon',() => {
        render(<Icon />)
    });
    it("button content testing", () => {
        const wrapper = shallow(<Button>=</Button>);
        const equals = <span>=</span>;
        expect(wrapper.contains(equals)).toEqual(true);
    });
    it ('sum 2 and 5 should be equal 7', () => {
        const sum = Calculation(2, 5, '+');
        expect(sum).toBeDefined();
        expect(sum).toEqual(7);
    });
    it ('div 6 and 2 should be equal 3', () => {
        const sum = Calculation(6, 2, '/');
        expect(sum).toBeDefined();
        expect(sum).toEqual(3);
    });
    it ('rem 8 and 2 should be equal 0', () => {
        const sum = Calculation(8, 2, '%');
        expect(sum).toBeDefined();
        expect(sum).toEqual(0);
    });
    it ('hp 1 and 10 should be equal 7', () => {
        const sum = Calculation(1, 10, 'hp');
        expect(sum).toBeDefined();
        expect(sum).toEqual(7);
    })
})

