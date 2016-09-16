/*
 * This class was created by tylerhyperHD. The contents of the class contain information from TFM,
 * and the methods used to inject into TFM are made by tylerhyperHD. These methods are under copyright
 * pending and may not be used without this statement.
 * You must inject a line of code that allows the method to be called, so use caution.
 */
package com.mcplugindev.freedombot;

import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.admin.AdminList;

public class TotalFreedom5_Getter {

    public TotalFreedomMod freedommod;

    private TotalFreedom5_Getter() {
        // You must have an added injection into the TFM to do this action
        freedommod = TotalFreedomMod.plugin();
    }

    public AdminList getAdminList() {
        return freedommod.al;
    }

    public static TotalFreedom5_Getter getInstance() {
        return TotalFreedom5_GetterHolder.INSTANCE;
    }

    private static class TotalFreedom5_GetterHolder {

        private static final TotalFreedom5_Getter INSTANCE = new TotalFreedom5_Getter();
    }
}
