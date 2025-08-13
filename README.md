**Minha API RESTFull**

```mermaid

classDiagram
    class ConviteCasamento {
    }

    class listaDecasamento {
        +adicionarConvidado()
        +removerConvidado()
        +mostrarConvidados()
    }

    class presentearNoivos {
        +presentear()
        +ajudarNaCachinha()
        +cachinhaDosNoivos()
    }

    class infoCasamento {
        +enderecoCasamento
        +dataDoCasamento
        +inicioCerimonia
        +inicioBuffet
    }

    ConviteCasamento --> listaDecasamento
    ConviteCasamento --> presentearNoivos
    ConviteCasamento --> infoCasamento
