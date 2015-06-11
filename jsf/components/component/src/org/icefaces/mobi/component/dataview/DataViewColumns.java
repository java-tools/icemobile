package org.icefaces.mobi.component.dataview;

import org.icemobile.model.DataViewColumnsModel;

/**
 * Copyright 2010-2013 ICEsoft Technologies Canada Corp.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * <p/>
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * User: Nils Lundquist
 * Date: 2013-04-01
 * Time: 10:47 AM
 */
public class DataViewColumns extends DataViewColumnsBase {
    public DataViewColumnsModel getModel() {
        Object value = getValue();

        if (value instanceof DataViewColumnsModel)
            return (DataViewColumnsModel) value;

        return new DataViewComponentColumnsModel(this);
    }
}
