//
// (c) 2006 DS Data Systems UK Ltd, All rights reserved.
//
// DS Data Systems and KonaKart and their respective logos, are 
// trademarks of DS Data Systems UK Ltd. All rights reserved.
//
// The information in this document is the proprietary property of
// DS Data Systems UK Ltd. and is protected by English copyright law,
// the laws of foreign jurisdictions, and international treaties,
// as applicable. No part of this document may be reproduced,
// transmitted, transcribed, transferred, modified, published, or
// translated into any language, in any form or by any means, for
// any purpose other than expressly permitted by DS Data Systems UK Ltd.
// in writing.
//
package com.konakart.client.util;

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * A miscellaneous collection of static validation utilities
 */
public class GWT_Validation
{
    // Used to validate an email
    private static final String REGEX_EMAIL = "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";

    /**
     * Style of widgets when they contain valid data
     */
    public static final String TEXT_BOX_STYLE = "konakart-TextBox";

    /**
     * Style of widgets when they contain invalid data
     */
    public static final String TEXT_BOX_INVALID_STYLE = "konakart-TextBox-Invalid";

    /**
     * Private constructor - all static methods here
     */
    private GWT_Validation()
    {
    }

    /**
     * Validates an integer value in a textbox. If the value is null or an empty string, we return
     * true since it is optional.
     * 
     * 
     * @param tb
     *            the textbox to validate
     * @param min
     *            the minimum allowed number - not checked if this is null
     * @param max
     *            the maximum allowed number - not checked if this is null
     * @param tipText
     *            if not null, this is the text that is set to the title of the textbox if
     *            validation is successful
     * @return true if the number in the textbox is OK, false otherwise
     */
    public static boolean validateIntOptional(TextBox tb, Integer min, Integer max, String tipText)
    {
        if (tb == null || tb.getText() == null || tb.getText().length() == 0)
        {
            if (tb != null)
            {
                setStyle(tb, TEXT_BOX_STYLE);
            }
            return true;
        }
        return validateInt(tb, min, max, tipText);
    }

    /**
     * Validates an integer value in a textbox.
     * 
     * @param tb
     *            the textbox to validate
     * @param min
     *            the minimum allowed number - not checked if this is null
     * @param max
     *            the maximum allowed number - not checked if this is null
     * @param tipText
     *            if not null, this is the text that is set to the title of the textbox if
     *            valiadation is successful
     * @return true if the number in the textbox is OK, false otherwise
     */
    public static boolean validateInt(TextBox tb, Integer min, Integer max, String tipText)
    {
        boolean validationResult = true;

        // determine whether it's valid input

        try
        {
            // Throws an exception if tb==null or tb.getText() isn't an int
            int id = Integer.parseInt(tb.getText());

            if (min != null && id < min.intValue())
            {
                validationResult = false;
            } else if (max != null && id > max.intValue())
            {
                validationResult = false;
            }
        } catch (Exception e)
        {
            validationResult = false;
        }

        // Set the style

        if (validationResult == true)
        {
            setStyle(tb, TEXT_BOX_STYLE);
        } else
        {
            setStyle(tb, TEXT_BOX_INVALID_STYLE);
        }

        // Set the tip Text

        if (validationResult == true && tipText != null)
        {
            tb.setTitle(tipText);
        } else
        {
            if (max != null && min != null)
            {
                tb.setTitle("Number must be between " + min.intValue() + " and " + max.intValue());
            } else if (max != null && min == null)
            {
                tb.setTitle("Number must be less than or equal to " + max.intValue());
            } else if (max == null && min != null)
            {
                tb.setTitle("Number must be greater than or equal to " + min.intValue());
            } else
            {
                tb.setTitle("Number must be an integer");
            }
        }

        return validationResult;
    }

    /**
     * Validates a double value in a textbox. If the value is null or an empty string, we return
     * true since it is optional.
     * 
     * @param tb
     *            the textbox to validate
     * @param min
     *            the minimum allowed number - not checked if this is null
     * @param max
     *            the maximum allowed number - not checked if this is null
     * @param tipText
     *            if not null, this is the text that is set to the title of the textbox if
     *            valiadation is successful
     * @return true if the number in the textbox is OK, false otherwise
     */
    public static boolean validateDoubleOptional(TextBox tb, Double min, Double max, String tipText)
    {
        if (tb == null || tb.getText() == null || tb.getText().length() == 0)
        {
            if (tb != null)
            {
                setStyle(tb, TEXT_BOX_STYLE);
            }
            return true;
        }
        return validateDouble(tb, min, max, tipText);
    }

    /**
     * Validates a double value in a textbox.
     * 
     * @param tb
     *            the textbox to validate
     * @param min
     *            the minimum allowed number - not checked if this is null
     * @param max
     *            the maximum allowed number - not checked if this is null
     * @param tipText
     *            if not null, this is the text that is set to the title of the textbox if
     *            valiadation is successful
     * @return true if the number in the textbox is OK, false otherwise
     */
    public static boolean validateDouble(TextBox tb, Double min, Double max, String tipText)
    {
        boolean validationResult = true;

        // determine whether it's valid input

        try
        {

            // Throws an exception if tb==null or tb.getText() isn't a double
            double doub = Double.parseDouble(tb.getText());

            if (min != null && doub < min.doubleValue())
            {
                validationResult = false;
            } else if (max != null && doub > max.doubleValue())
            {
                validationResult = false;
            }
        } catch (Exception e)
        {
            validationResult = false;
        }

        // Set the style

        if (validationResult == true)
        {
            setStyle(tb, TEXT_BOX_STYLE);
        } else
        {
            setStyle(tb, TEXT_BOX_INVALID_STYLE);
        }

        // Set the tip Text

        if (validationResult == true && tipText != null)
        {
            tb.setTitle(tipText);
        } else
        {
            if (max != null && min != null)
            {
                tb.setTitle("Value must be between " + min.intValue() + " and " + max.intValue());
            } else if (max != null && min == null)
            {
                tb.setTitle("Value must be less than or equal to " + max.intValue());
            } else if (max == null && min != null)
            {
                tb.setTitle("Value must be greater than or equal to " + min.intValue());
            } else
            {
                tb.setTitle("Value must be a decimal number");
            }
        }

        return validationResult;
    }

    /**
     * Validates text in a textarea. If the value is null or an empty string, we return true since
     * it is optional.
     * 
     * @param ta
     *            the textarea to validate
     * @param min
     *            the minimum allowed length - not checked if this is null
     * @param max
     *            the maximum allowed length - not checked if this is null
     * @param tipText
     *            if not null, this is the text that is set to the title of the textbox if
     *            valiadation is successful
     * @return true if the number in the textbox is OK, false otherwise
     */
    public static boolean validateTextOptional(TextArea ta, Integer min, Integer max, String tipText)
    {
        if (ta == null || ta.getText() == null || ta.getText().length() == 0)
        {
            if (ta != null)
            {
                ta.setStyleName(TEXT_BOX_STYLE);
            }
            return true;
        }
        return validateText(ta, min, max, tipText);
    }

    /**
     * Validates text in a textarea.
     * 
     * @param ta
     *            the textarea to validate
     * @param min
     *            the minimum allowed length - not checked if this is null
     * @param max
     *            the maximum allowed length - not checked if this is null
     * @param tipText
     *            if not null, this is the text that is set to the title of the textbox if
     *            valiadation is successful
     * @return true if the number in the textbox is OK, false otherwise
     */
    public static boolean validateText(TextArea ta, Integer min, Integer max, String tipText)
    {
        boolean validationResult = true;

        try
        {
            // Throws an exception if tb == null or tb.getText() == null
            int len = ta.getText().length();

            if (min != null && len < min.intValue())
            {
                validationResult = false;
            } else if (max != null && len > max.intValue())
            {
                validationResult = false;
            }
        } catch (Exception e)
        {
            validationResult = false;
        }

        // Set the style

        if (validationResult == true)
        {
            setStyle(ta, TEXT_BOX_STYLE);
        } else
        {
            setStyle(ta, TEXT_BOX_INVALID_STYLE);
        }

        // Set the tip Text

        if (validationResult == true && tipText != null)
        {
            ta.setTitle(tipText);
        } else
        {
            if (max != null && min != null)
            {
                ta.setTitle("Text must be between " + min.intValue() + " and " + max.intValue()
                        + " characters");
            } else if (max != null && min == null)
            {
                ta.setTitle("Text must be less than or equal to " + max.intValue() + " characters");
            } else if (max == null && min != null)
            {
                ta.setTitle("Text must be greater than or equal to " + min.intValue()
                        + " characters");
            } else
            {
                ta.setTitle("");
            }
        }

        return validationResult;
    }

    /**
     * Validates text in a textbox. If the value is null or an empty string, we return true since it
     * is optional.
     * 
     * @param tb
     *            the textbox to validate
     * @param min
     *            the minimum allowed length - not checked if this is null
     * @param max
     *            the maximum allowed length - not checked if this is null
     * @param tipText
     *            if not null, this is the text that is set to the title of the textbox if
     *            valiadation is successful
     * @return true if the number in the textbox is OK, false otherwise
     */
    public static boolean validateTextOptional(TextBox tb, Integer min, Integer max, String tipText)
    {
        if (tb == null || tb.getText() == null || tb.getText().length() == 0)
        {
            if (tb != null)
            {
                setStyle(tb, TEXT_BOX_STYLE);
            }
            return true;
        }
        return validateText(tb, min, max, tipText);
    }

    /**
     * Validates an eMail address in a textbox. If the value is null or an empty string, we return
     * true since it is optional.
     * 
     * @param tb
     *            the textbox to validate
     * @param min
     *            the minimum allowed length - not checked if this is null
     * @param max
     *            the maximum allowed length - not checked if this is null
     * @param tipText
     *            if not null, this is the text that is set to the title of the textbox if
     *            validation is successful
     * @return true if the string in the textbox is OK, false otherwise
     */
    public static boolean validateEmailOptional(TextBox tb, Integer min, Integer max, String tipText)
    {
        boolean validationResult = true;
        if (tb == null || tb.getText() == null || tb.getText().length() == 0)
        {
            if (tb != null)
            {
                setStyle(tb, TEXT_BOX_STYLE);
            }
            return true;
        }

        if (!tb.getText().matches(REGEX_EMAIL))
        {
            setStyle(tb, TEXT_BOX_INVALID_STYLE);
            validationResult = false;
        } else
        {
            setStyle(tb, TEXT_BOX_STYLE);
            validationResult = true;
        }
        if (validationResult == true && tipText != null)
        {
            tb.setTitle(tipText);
        } else
        {
            tb.setTitle("The eMail address is not valid");
        }

        return validationResult;
    }

    /**
     * Validates text in a textbox.
     * 
     * @param tb
     *            the textbox to validate
     * @param min
     *            the minimum allowed length - not checked if this is null
     * @param max
     *            the maximum allowed length - not checked if this is null
     * @param tipText
     *            if not null, this is the text that is set to the title of the textbox if
     *            valiadation is successful
     * @return true if the number in the textbox is OK, false otherwise
     */
    public static boolean validateText(TextBox tb, Integer min, Integer max, String tipText)
    {
        boolean validationResult = true;

        try
        {
            // Throws an exception if tb == null or tb.getText() == null
            int len = tb.getText().length();

            if (min != null && len < min.intValue())
            {
                validationResult = false;
            } else if (max != null && len > max.intValue())
            {
                validationResult = false;
            }
        } catch (Exception e)
        {
            validationResult = false;
        }

        // Set the style

        if (validationResult == true)
        {
            setStyle(tb, TEXT_BOX_STYLE);
        } else
        {
            setStyle(tb, TEXT_BOX_INVALID_STYLE);
        }

        // Set the tip Text

        if (validationResult == true && tipText != null)
        {
            tb.setTitle(tipText);
        } else
        {
            if (max != null && min != null)
            {
                tb.setTitle("Text must be between " + min.intValue() + " and " + max.intValue()
                        + " characters");
            } else if (max != null && min == null)
            {
                tb.setTitle("Text must be less than or equal to " + max.intValue() + " characters");
            } else if (max == null && min != null)
            {
                tb.setTitle("Text must be greater than or equal to " + min.intValue()
                        + " characters");
            } else
            {
                tb.setTitle("");
            }
        }

        return validationResult;
    }

    /**
     * Validates text in a passwordtextbox.
     * 
     * @param tb
     *            the passwordtextbox to validate
     * @param min
     *            the minimum allowed length - not checked if this is null
     * @param max
     *            the maximum allowed length - not checked if this is null
     * @param tipText
     *            if not null, this is the text that is set to the title of the textbox if
     *            valiadation is successful
     * @return true if the number in the textbox is OK, false otherwise
     */
    public static boolean validatePasswordText(PasswordTextBox tb, Integer min, Integer max,
            String tipText)
    {
        boolean validationResult = true;

        try
        {
            // Throws an exception if tb == null or tb.getText() == null
            int len = tb.getText().length();

            if (min != null && len < min.intValue())
            {
                validationResult = false;
            } else if (max != null && len > max.intValue())
            {
                validationResult = false;
            }
        } catch (Exception e)
        {
            validationResult = false;
        }

        // Set the style

        if (validationResult == true)
        {
            setStyle(tb, TEXT_BOX_STYLE);
        } else
        {
            setStyle(tb, TEXT_BOX_INVALID_STYLE);
        }

        // Set the tip Text

        if (validationResult == true && tipText != null)
        {
            tb.setTitle(tipText);
        } else
        {
            if (max != null && min != null)
            {
                tb.setTitle("Text must be between " + min.intValue() + " and " + max.intValue()
                        + " characters");
            } else if (max != null && min == null)
            {
                tb.setTitle("Text must be less than " + max.intValue() + " characters");
            } else if (max == null && min != null)
            {
                tb.setTitle("Text must be greater than " + min.intValue() + " characters");
            } else
            {
                tb.setTitle("");
            }
        }

        return validationResult;
    }

    /**
     * Validates a list box based on its selected index
     * 
     * @param lb
     *            the textbox to validate
     * @param min
     *            the minimum allowed number - not checked if this is null
     * @param max
     *            the maximum allowed number - not checked if this is null
     * @param tipText
     *            if not null, this is the text that is set to the title of the textbox if
     *            validation is successful
     * @return true if the index of the list box is OK, false otherwise
     */
    public static boolean validateListBox(ListBox lb, Integer min, Integer max, String tipText)
    {
        boolean validationResult = true;

        // determine whether it's valid input

        try
        {
            // Throws an exception if lb==null
            int index = lb.getSelectedIndex();

            if (min != null && index < min.intValue())
            {
                validationResult = false;
            } else if (max != null && index > max.intValue())
            {
                validationResult = false;
            }
        } catch (Exception e)
        {
            validationResult = false;
        }

        // Set the style

        if (validationResult == true)
        {
            lb.setStyleName(TEXT_BOX_STYLE);
        } else
        {
            lb.setStyleName(TEXT_BOX_INVALID_STYLE);
        }

        // Set the tip Text

        if (validationResult == true && tipText != null)
        {
            lb.setTitle(tipText);
        } else
        {
            lb.setTitle("You must select an entry from the list");
        }

        return validationResult;
    }

    /**
     * Set the widget style
     * 
     * @param w
     * @param style
     */
    private static void setStyle(Widget w, String style)
    {
        if (style.equals(TEXT_BOX_STYLE))
        {
            w.setStyleName(TEXT_BOX_STYLE);
            w.addStyleName("main");
        } else
        {
            w.setStyleName(TEXT_BOX_INVALID_STYLE);
            w.addStyleName("main");
        }
    }

}