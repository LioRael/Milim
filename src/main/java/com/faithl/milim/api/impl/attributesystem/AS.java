package com.faithl.milim.api.impl.attributesystem;

import com.faithl.milim.AttributeManager;
import com.skillw.attsystem.api.AttrAPI;
import com.skillw.attsystem.api.attribute.compound.AttributeDataCompound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AS extends AttributeManager {
    @Override
    public Object getData(LivingEntity livingEntity) {
        return AttrAPI.getAttrData(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, List<String> attribute) {
        AttrAPI.removeAttribute(livingEntity,source);
        AttrAPI.addAttribute(livingEntity,source,attribute,false);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, HashMap<String, Number[]> attribute) {
        AttrAPI.removeAttribute(livingEntity,source);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, String attribute) {
        List<String> list = new ArrayList<>();
        AttrAPI.removeAttribute(livingEntity,source);
        AttrAPI.addAttribute(livingEntity,source,list,false);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, ItemStack itemStack) {
        AttrAPI.removeAttribute(livingEntity,source);
        AttrAPI.readItem(itemStack,livingEntity,null);
    }

    @Override
    public void deleteAttribute(String source, LivingEntity livingEntity) {
        AttrAPI.removeAttribute(livingEntity,source);
    }
}
