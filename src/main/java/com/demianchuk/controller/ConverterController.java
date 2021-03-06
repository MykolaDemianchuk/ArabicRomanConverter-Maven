package com.demianchuk.controller;

import com.demianchuk.models.checker.NumeralChecker;
import com.demianchuk.models.converter.NumeralConverter;
import com.demianchuk.util.ConverterUtil;
import com.demianchuk.view.ConverterView;

import javax.swing.*;
import java.awt.event.*;

public class ConverterController {

    protected ConverterView view;
    private NumeralChecker checker;
    private NumeralConverter converter;

    protected ConverterController(ConverterView view, NumeralChecker checker,
                                  NumeralConverter converter) {
        this.view = view;
        this.checker = checker;
        this.converter = converter;
    }

    protected boolean isEnter(KeyEvent evt) {
        return evt.getKeyCode() == 10;
    }

    protected void performAction(JTextField from, JTextField to) {
        String value = ConverterUtil.getValidValue(from.getText());
        if (checker.isLegalNumeral(value)) {
            to.setText(converter.convert(value));
        } else {
            to.setText("");
            view.displayErrorMessage("Invalid input");
        }
    }
}
