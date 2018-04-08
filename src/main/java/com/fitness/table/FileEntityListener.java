package com.fitness.table;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.MANDATORY;

public class FileEntityListener {

    private String created_by;
    private String last_modified_by;

    @PrePersist
    public void prePersist(String created_by) {
        if(created_by==null)
            created_by="USER";

        if(last_modified_by==null)
            last_modified_by="USER";
    }

//    @PreUpdate
//    public void preUpdate() {
//
//    }
//
//    @PreRemove
//    public void preRemove() {
//    }

//    @Transactional(MANDATORY)
//    private void perform(File target, Action action) {
//        EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
//        entityManager.persist(new FileHistory(target, action));
//    }


    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getLast_modified_by() {
        return last_modified_by;
    }

    public void setLast_modified_by(String last_modified_by) {
        this.last_modified_by = last_modified_by;
    }
}
