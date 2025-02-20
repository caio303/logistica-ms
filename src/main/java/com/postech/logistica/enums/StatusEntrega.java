package com.postech.logistica.enums;

public enum StatusEntrega {
    INICIADO(1),
    EM_SEPARACAO(2),
    EM_ROTA(3),
    SAIU_PARA_ENTREGA(4),
    ENTREGA_CONCLUIDA(5),
    CANCELADO(6);

    private int id;

    StatusEntrega(int id) {
        this.id = id;
    }

    public static StatusEntrega deId(int id) {
        for (var status : StatusEntrega.values()) {
            if (status.id == id) {
                return status;
            }
        }

        return null;
    }

    public int getId() {
        return id;
    }
}
