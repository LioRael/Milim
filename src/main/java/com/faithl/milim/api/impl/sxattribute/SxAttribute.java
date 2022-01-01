package com.faithl.milim.api.impl.sxattribute;

import com.faithl.milim.AttributeManager;
import com.faithl.milim.Milim;
import com.faithl.milim.util.Collection;
import github.saukiya.sxattribute.SXAttribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.*;

/**
 * @author Leosouthey
 * @date 2021/12/31-19:47
 **/
public class SxAttribute extends AttributeManager {

    @Override
    public Object getData(LivingEntity livingEntity) {
        return SXAttribute.getApi().getEntityData(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, List<String> attribute) {
        SXAttribute.getApi().removeEntityAPIData(Milim.instance.getClass(), livingEntity.getUniqueId());
        SXAttribute.getApi().setEntityAPIData(Milim.instance.getClass(), livingEntity.getUniqueId(), SXAttribute.getApi().loadListData(attribute));
        SXAttribute.getApi().updateData(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, HashMap<String, Number[]> attribute) {
        SXAttribute.getApi().removeEntityAPIData(Milim.instance.getClass(), livingEntity.getUniqueId());
        List<String> list = new ArrayList<String>();
        for (String key : attribute.keySet()) {
            list.add(key + ": " + Arrays.toString(attribute.get(key)));
        }
        SXAttribute.getApi().setEntityAPIData(Milim.instance.getClass(), livingEntity.getUniqueId(), SXAttribute.getApi().loadListData(list));
        SXAttribute.getApi().updateData(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, String attribute) {
        SXAttribute.getApi().removeEntityAPIData(Milim.instance.getClass(), livingEntity.getUniqueId());
        SXAttribute.getApi().setEntityAPIData(Milim.instance.getClass(), livingEntity.getUniqueId(), SXAttribute.getApi().loadListData(Collection.asList(attribute)));
        SXAttribute.getApi().updateData(livingEntity);
    }

    @Override
    public void setAttribute(String source, LivingEntity livingEntity, ItemStack itemStack) {
        SXAttribute.getApi().removeEntityAPIData(Milim.instance.getClass(), livingEntity.getUniqueId());
        SXAttribute.getApi().setEntityAPIData(Milim.instance.getClass(), livingEntity.getUniqueId(), SXAttribute.getApi().loadListData(
                Objects.requireNonNull(itemStack.getItemMeta()).getLore()));
        SXAttribute.getApi().updateData(livingEntity);
    }

    @Override
    public void deleteAttribute(String source, LivingEntity livingEntity) {
        SXAttribute.getApi().removeEntityAPIData(Milim.instance.getClass(), livingEntity.getUniqueId());
        SXAttribute.getApi().updateData(livingEntity);
    }

}
