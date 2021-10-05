package me.hsgamer.bettergui.additionalmodifiers;

import me.hsgamer.bettergui.lib.core.bukkit.item.ItemMetaModifier;
import me.hsgamer.bettergui.lib.core.common.interfaces.StringReplacer;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ModifyNameModifier extends ItemMetaModifier {
    private String name;

    @Override
    public String getName() {
        return "modify-name";
    }

    @Override
    public ItemMeta modifyMeta(ItemMeta meta, UUID uuid, Map<String, StringReplacer> stringReplacerMap) {
        String metaName = Optional.ofNullable(meta.getDisplayName()).orElse("");
        String modifyName = StringReplacer.replace(name, uuid, stringReplacerMap.values());
        meta.setDisplayName(modifyName.replace("{original_name}", metaName));
        return meta;
    }

    @Override
    public void loadFromItemMeta(ItemMeta meta) {
        // EMPTY
    }

    @Override
    public boolean canLoadFromItemMeta(ItemMeta meta) {
        return false;
    }

    @Override
    public boolean compareWithItemMeta(ItemMeta meta, UUID uuid, Map<String, StringReplacer> stringReplacerMap) {
        return false;
    }

    @Override
    public Object toObject() {
        return this.name;
    }

    @Override
    public void loadFromObject(Object object) {
        this.name = String.valueOf(object);
    }
}
