package me.gleep.biomesplus.utils;

import me.gleep.biomesplus.BiomesPlus;
import me.gleep.biomesplus.effects.FreezeEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    private static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, BiomesPlus.MOD_ID);

    public static void init() {
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }


    //Effects
    public static final RegistryObject<Effect> FREEZE = EFFECTS.register("freeze", FreezeEffect::new);
}
