/*
 * Copyright (C) 2005-2015 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */
package de.schlichtherle.license;

import de.schlichtherle.util.ObfuscatedString;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Looks up the resources for this package in a Resource Bundle.
 * Provided for comfort.
 *
 * @author Christian Schlichtherle
 * @version $Id$
 */
public class Resources {

//    private static final String CLASS_NAME = new ObfuscatedString(new long[]{
//        0x54087D071FCE4840L, 0x50F993D8A5287E71L, 0x3B4F078A163B6812L,
//        0xE97B3E32094E2DB9L, 0x5C18E921228781ECL, 0xDF350057733EC2A7L
//    }).toString();
//
///* => "de.schlichtherle.license.Resources" */

    private static final String CLASS_NAME = new ObfuscatedString(new long[]{
        0x3B99B9A020A8C05DL, 0x99C23E7D4DFFCCDL, 0xF0C3599EA2080C4L
    }).toString();//=>Resources

    private static final ResourceBundle resources
        = ResourceBundle.getBundle(CLASS_NAME);

    /**
     * Looks up a string resource identified by {@code key} in
     * {@code resources}.
     */
    public static String getString(String key) {
        return resources.getString(key);
    }

    /**
     * Looks up a string resource identified by {@code key} in
     * {@code resources} and formats it as a message using
     * {@code MessageFormat.format} with the given {@code arguments}.
     */
    public static String getString(String key, Object[] arguments) {
        return MessageFormat.format(getString(key), arguments);
    }

    /**
     * Looks up a string resource identified by {@code key} in
     * {@code resources} and formats it as a message using
     * {@code MessageFormat.format} with the given singular {@code argument}.
     */
    public static String getString(String key, Object argument) {
        return MessageFormat.format(getString(key), new Object[]{argument});
    }

    /**
     * You cannot instantiate this class.
     */
    protected Resources() {
    }
}
