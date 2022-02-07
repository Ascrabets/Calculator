import React from "react";
import {mount, render, shallow} from "enzyme";
import {Button} from "../components/atom/Button";
import {Input} from "../components/atom/Input";
import {Icon} from "../components/atom/Icon";


describe("Render elements", () => {
    it("testing button", () => {
        render(<Button/>)
    })
    it("testing input", () => {
        render(<Input/>)
    })
    it('testing icon',() => {
        render(<Icon />)
    });
    it("button content testing", () => {
        const wrapper = shallow(<Button>=</Button>);
        const equals = <span>=</span>;
        expect(wrapper.contains(equals)).toEqual(true);
    })
})

