package me.hsgamer.bettergui.additionalmodifiers;

import me.hsgamer.bettergui.lib.core.bukkit.item.ItemMetaModifier;
import me.hsgamer.bettergui.lib.core.common.CollectionUtils;
import me.hsgamer.bettergui.lib.core.common.interfaces.StringReplacer;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class TopLoreModifier extends ItemMetaModifier {
    private final List<String> lore = new ArrayList<>();

    private List<String> getReplacedLore(UUID uuid, Map<String, StringReplacer> map) {
        List<String> replacedLore = new ArrayList<>(lore);
        replacedLore.replaceAll(s -> StringReplacer.replace(s, uuid, map.values()));
        return replacedLore;
    }

    @Override
    public ItemMeta modifyMeta(ItemMeta itemMeta, UUID uuid, Map<String, StringReplacer> map) {
        List<String> newLore = new ArrayList<>(getReplacedLore(uuid, map));
        Optional.ofNullable(itemMeta.getLore()).ifPresent(newLore::addAll);
        itemMeta.setLore(newLore);
        return itemMeta;
    }

    @Override
    public void loadFromItemMeta(ItemMeta itemMeta) {
        // EMPTY
    }

    @Override
    public boolean canLoadFromItemMeta(ItemMeta itemMeta) {
        return false;
    }

    @Override
    public boolean compareWithItemMeta(ItemMeta itemMeta, UUID uuid, Map<String, StringReplacer> map) {
        return false;
    }

    @Override
    public String getName() {
        return "top-lore";
    }

    @Override
    public Object toObject() {
        return lore;
    }

    @Override
    public void loadFromObject(Object o) {
        lore.addAll(CollectionUtils.createStringListFromObject(o, false));
    }
}
