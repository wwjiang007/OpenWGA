/*******************************************************************************
 * Copyright 2009, 2010 Innovation Gate GmbH. All Rights Reserved.
 * 
 * This file is part of the OpenWGA server platform.
 * 
 * OpenWGA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * In addition, a special exception is granted by the copyright holders
 * of OpenWGA called "OpenWGA plugin exception". You should have received
 * a copy of this exception along with OpenWGA in file COPYING.
 * If not, see <http://www.openwga.com/gpl-plugin-exception>.
 * 
 * OpenWGA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with OpenWGA in file COPYING.
 * If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package de.innovationgate.wgpublisher.plugins;

import de.innovationgate.wga.common.beans.csconfig.v1.PluginID;
import de.innovationgate.wgpublisher.WGACore;

public class ResetDatabaseOperation implements WorkspaceOperation {

    private PluginID _pluginID;

    public ResetDatabaseOperation(WGAPlugin plugin) {
        _pluginID = plugin.getPluginID();
    }
    
    public String getTitle() {
        return "Reset plugin database";
    }

    public WGAPlugin perform(WGAPluginSet set, WGACore core, boolean workspaceOnly) throws PluginOperationException {
        WGAPlugin plugin = set.getPluginByID(_pluginID);
        if (!workspaceOnly) {
            String dbKey = plugin.buildDatabaseKey();
            core.removeContentDB(dbKey);
            set.deletePluginDatabase(plugin);
        }
        return plugin;
    }

}
