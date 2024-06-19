package com.cosmo.galactic_horizons.screen;

import com.cosmo.galactic_horizons.GalacticHorizons;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandler {
	public static final ScreenHandlerType<DimensionalCrafterScreenHandler> DIMENSIONAL_CRAFTER_SCREEN_HANDLER_SCREEN =
		Registry.register(Registries.SCREEN_HANDLER_TYPE,new Identifier(GalacticHorizons.MOD_ID,"dimensional_crafter"),
			new ExtendedScreenHandlerType<>((syncId, inventory, buf) -> new DimensionalCrafterScreenHandler(syncId, inventory, buf, ScreenHandlerContext.EMPTY)));

	public static void registerScreenHandlers() {
		GalacticHorizons.LOGGER.info("Registering Screen Handlers for " + GalacticHorizons.MOD_ID);
	}
}
