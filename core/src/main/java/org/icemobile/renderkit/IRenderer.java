/*
 * Copyright 2004-2012 ICEsoft Technologies Canada Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS
 * IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.icemobile.renderkit;

import java.io.IOException;

import org.icemobile.component.IMobiComponent;

public interface IRenderer {
    
    public void encodeBegin(IMobiComponent component, IResponseWriter writer, boolean isJSP)
            throws IOException;
    public void encodeEnd(IMobiComponent component, IResponseWriter writer, boolean isJSP)
            throws IOException;

}
