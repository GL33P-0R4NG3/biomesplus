package me.gleep.biomesplus.effects;

import me.gleep.biomesplus.utils.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class FreezeEffect extends Effect {
    public FreezeEffect() {
        super(EffectType.HARMFUL, 0x66c4ff);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        if (this.equals(RegistryHandler.FREEZE.get()) && entityLivingBaseIn.isEntityUndead()) {
            entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, 0.1F * amplifier);
        }
        super.performEffect(entityLivingBaseIn, amplifier);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        if (this == RegistryHandler.FREEZE.get()) {
            int l = 50 >> amplifier;
            if (l > 0) {
                return duration % l == 0;
            } else {
                return true;
            }
        }
        return super.isReady(duration, amplifier);
    }
}