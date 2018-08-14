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

import com.yelp.exception.NullParameterException;

import lombok.Data;

@Data
public class AutoCompleteParameters implements Parameters {
    private String text;
    private Double latitude;
    private Double longitude;
    private Locale locale;

    public String getParameters() throws NullParameterException {
        StringBuilder builder = new StringBuilder("?");
        if (text == null) {
            throw new NullParameterException("text cannot be null for /autocomplete endpoint.");
        }
        builder.append("text=").append(text);

        if (latitude != null) {
            builder.append("&latitude=").append(String.valueOf(latitude));
        }
        if (longitude != null) {
            builder.append("&longitude=").append(String.valueOf(longitude));
        }
        if (locale != null) {
            builder.append("&locale=").append(locale);
        }

        return builder.toString();
    }
}
