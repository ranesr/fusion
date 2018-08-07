//  The MIT License
//
//  Copyright © 2018 Saurabh Rane
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy
//  of this software and associated documentation files (the "Software"), to deal
//  in the Software without restriction, including without limitation the rights
//  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//  copies of the Software, and to permit persons to whom the Software is
//  furnished to do so, subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//  SOFTWARE.

package com.yelp.model.parameters;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum  Locale {
    // Czech Republic, Czech
    CS_CZ("cs_CZ"),

    // Denmark, Danish
    DA_DK("da_DK"),

    // Austria, German
    DE_AT("de_AT"),

    // Switzerland, German
    DE_CH("de_CH"),

    // Germany, German
    DE_DE("de_DE"),

    // Australia, English
    EN_AU("en_AU"),

    // Belgium, English
    EN_BE("en_BE"),

    // Canada, English
    EN_CA("en_CA"),

    // Switzerland, English
    EN_CH("en_CH"),

    // United Kingdom, English
    EN_GB("en_GB"),

    // Hong Kong, English
    EN_HK("en_HK"),

    // Republic of Ireland, English
    EN_IE("en_IE"),

    // Malaysia, English
    EN_MY("en_MY"),

    // New Zealand, English
    EN_NZ("en_NZ"),

    // Philippines, English
    EN_PH("en_PH"),

    // Singapore, English
    EN_SG("en_SG"),

    // United States, English
    EN_US("en_US"),

    // Argentina, Spanish
    ES_AR("es_AR"),

    // Chile, Spanish
    ES_CL("es_CL"),

    // Spain, Spanish
    ES_ES("es_ES"),

    // Mexico, Spanish
    ES_MX("es_MX"),

    // Finland, Finnish
    FI_FI("fi_FI"),

    // Philippines, Filipino
    FIL_PH("fil_PH"),

    // Belgium, French
    FR_BE("fr_BE"),

    // Canada, French
    FR_CA("fr_CA"),

    // Switzerland, French
    FR_CH("fr_CH"),

    // France, French
    FR_FR("fr_FR"),

    // Switzerland, Italian
    IT_CH("it_CH"),

    // Italy, Italian
    IT_IT("it_IT"),

    // Japan, Japanese
    JA_JP("ja_JP"),

    // Malaysia, Malay
    MS_MY("ms_MY"),

    // Norway, Norwegian
    NB_NO("nb_NO"),

    // Belgium, Dutch
    NL_BE("nl_BE"),

    // The Netherlands, Dutch
    NL_NL("nl_NL"),

    // Poland, Polish
    PL_PL("pl_PL"),

    // Brazil, Portuguese
    PT_BR("pt_BR"),

    // Portugal, Portuguese
    PT_PT("pt_PT"),

    // Finland, Swedish
    SV_FI("sv_FI"),

    // Sweden, Swedish
    SV_SE("sv_SE"),

    // Turkey, Turkish
    TR_TR("tr_TR"),

    // Hong Kong, Chinese
    ZH_HK("zh_HK"),

    // Taiwan, Chinese
    ZH_TW("zh_TW");

    @Getter
    private String value;

    @JsonCreator
    public static Locale locale(String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        for (Locale locale: values()) {
            if (value.equals(locale.getValue())) {
                return locale;
            }
        }
        throw new IllegalArgumentException();
    }
}
