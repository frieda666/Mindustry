package mindustry.world.consumers;

import arc.scene.ui.layout.*;
import arc.struct.*;
import mindustry.gen.*;
import mindustry.world.meta.*;

/** An abstract class that defines a type of resource that a block can consume. */
public abstract class Consume{
    /** If true, this consumer will not influence consumer validity. */
    public boolean optional;
    /** If true, this consumer will be displayed as a boost input. */
    public boolean booster;
    public boolean update = true;

    /**
     * Apply a filter to items accepted.
     * This should set all item IDs that are present in the filter to true.
     */
    public void applyItemFilter(Bits filter){

    }

    /**
     * Apply a filter to liquids accepted.
     * This should set all liquid IDs that are present in the filter to true.
     */
    public void applyLiquidFilter(Bits filter){

    }

    public Consume optional(boolean optional, boolean boost){
        this.optional = optional;
        this.booster = boost;
        return this;
    }

    public Consume boost(){
        return optional(true, true);
    }

    public Consume update(boolean update){
        this.update = update;
        return this;
    }

    public boolean isOptional(){
        return optional;
    }

    public boolean isBoost(){
        return booster;
    }

    public boolean isUpdate(){
        return update;
    }

    public abstract ConsumeType type();

    public void build(Building build, Table table){}

    /** Called when a consumption is triggered manually. */
    public void trigger(Building build){}

    public void update(Building build){}

    public void display(Stats stats){}

    public abstract boolean valid(Building build);
}
