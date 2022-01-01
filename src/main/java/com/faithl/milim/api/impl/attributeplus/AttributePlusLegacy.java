package com.faithl.milim.api.impl.attributeplus;

import com.faithl.milim.AttributeManager;
import com.faithl.milim.util.Collection;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.serverct.ersha.attribute.data.AttributeData;
import org.serverct.ersha.jd.AttributeAPI;

import java.util.*;

/**
 * @author Leosouthey
 * @date 2021/12/31-20:17
 **/
public class AttributePlusLegacy extends AttributeManager {

    @Override
    public AttributeData getData(LivingEntity livingEntity) {
        return AttributeAPI.getAttrData(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, List<String> attribute) {
        AttributeAPI.deleteAttribute((Player) livingEntity, source);
        AttributeAPI.addAttribute((Player) livingEntity, source, attribute);
        AttributeAPI.updateEntityAttribute(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, HashMap<String, Number[]> attribute) {
        AttributeAPI.deleteAttribute((Player) livingEntity, source);
        List<String> list = new ArrayList<String>();
        for (String key : attribute.keySet()) {
            list.add(key + ": " + Arrays.toString(attribute.get(key)));
        }
        AttributeAPI.addAttribute((Player) livingEntity, source, list);
        AttributeAPI.updateEntityAttribute(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, String attribute) {
        AttributeAPI.deleteAttribute((Player) livingEntity, source);
        AttributeAPI.addAttribute((Player) livingEntity, source, Collection.asList(attribute));
        AttributeAPI.updateEntityAttribute(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, ItemStack itemStack) {
        AttributeAPI.deleteAttribute((Player) livingEntity, source);
        AttributeAPI.addAttribute((Player) livingEntity, source, Objects.requireNonNull(itemStack.getItemMeta()).getLore());
        AttributeAPI.updateEntityAttribute(livingEntity);
    }

    @Override
    public void deleteAttribute(String source, LivingEntity livingEntity) {
        AttributeAPI.deleteAttribute((Player) livingEntity, source);
        AttributeAPI.updateEntityAttribute(livingEntity);
    }

}
