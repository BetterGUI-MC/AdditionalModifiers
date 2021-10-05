package me.hsgamer.bettergui.additionalmodifiers;

import me.hsgamer.bettergui.api.addon.BetterGUIAddon;
import me.hsgamer.bettergui.builder.ItemModifierBuilder;

public final class AdditionalModifiers extends BetterGUIAddon {
    @Override
    public void onEnable() {
        ItemModifierBuilder.INSTANCE.register(BottomLoreModifier::new, "bottom-lore");
        ItemModifierBuilder.INSTANCE.register(TopLoreModifier::new, "top-lore");
        ItemModifierBuilder.INSTANCE.register(ModifyNameModifier::new, "modify-name");
    }
}
