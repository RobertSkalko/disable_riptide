package com.robertx22.disable_riptide.mixins;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @Inject(method = "getLevel(Lnet/minecraft/enchantment/Enchantment;Lnet/minecraft/item/ItemStack;)I", at = @At(value = "HEAD"), cancellable = true)
    private static void hookReturnZeroForRiptide(Enchantment enchantment, ItemStack stack, CallbackInfoReturnable<Integer> ci) {
        if (enchantment == Enchantments.RIPTIDE) {
            ci.setReturnValue(0);
        }
    }
}
