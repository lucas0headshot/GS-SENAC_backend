$(function() {
    $('#formLogin').submit(function(e) {
        e.preventDefault;

        $(this).validate({
            onsubmit: true,

            rules: {
                usuario: {
                    required: true
                },

                senha: {
                    required: true
                }
            },

            messages: {
                usuario: {
                    required: "Informe seu nome de usuário"
                },

                senha: {
                    required: "Informe sua senha"
                }
            },

            errorPlacement: (error, element) => {
                error.addClass('invalid-feedback');
                error.insertAfter(element);
            },

            highlight: (element) => {
                $(element).addClass("is-invalid");
            },

            unhighlight: (element) => {
                $(element).removeClass("is-invalid");
            }
        });

        if ($(this).valid()) {
            alert(`Bem-vindo, ${$('#usuario').val()}!`);
            return location.reload();
        }
    });



    $('#formCadastro').submit(function(e) {
        e.preventDefault;

        $(this).validate({
            onsubmit: true,

            rules: {
                usuario_cadastro: {
                    required: true
                },

                email_cadastro: {
                    required: true
                },

                senha_cadastro: {
                    required: true
                }
            },

            messages: {
                usuario: {
                    required: "Informe seu nome de usuário"
                },

                senha: {
                    required: "Informe sua senha"
                }
            },

            errorPlacement: (error, element) => {
                error.addClass('invalid-feedback');
                error.insertAfter(element);
            },

            highlight: (element) => {
                $(element).addClass("is-invalid");
            },

            unhighlight: (element) => {
                $(element).removeClass("is-invalid");
            }
        });

        if ($(this).valid()) {
            //TODO: limpar form & redirecionar
            alert('Bem-vindo!');
        }
    });



    $('#aCadastrarConta').click(function() {
        $('#entrar').addClass('d-none');
        return $('#cadastrar').removeClass('d-none');
    });
});