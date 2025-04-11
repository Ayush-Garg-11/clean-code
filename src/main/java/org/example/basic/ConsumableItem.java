package org.example.basic;

import java.time.LocalDate;

public class ConsumableItem {

    private LocalDate expirationDate;
    private Boolean approvedForConsumption;
    private Integer inspectorId;

    public ConsumableItem(LocalDate expirationDate, Boolean approvedForConsumption, Integer inspectorId) {
        this.expirationDate = expirationDate;
        this.approvedForConsumption = approvedForConsumption;
        this.inspectorId = inspectorId;
    }

    public boolean isEdible()
    {
        return (this.expirationDate.isAfter(LocalDate.now()) &&isInspected());
    }

    private boolean isInspected(){
        return (this.approvedForConsumption && this.inspectorId !=null);
    }
}
