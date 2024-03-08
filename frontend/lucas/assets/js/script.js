$(function() {
    /*
        Funções modal Login
    */
        $('#formLogin').validate({
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

        $('#formLogin').submit(function(e) {
            e.preventDefault();

            if ($(this).valid()) {
                alert(`Bem-vindo, ${$('#usuario').val()}!`);
                return location.reload();
            }
        });


        $('#aCadastrarConta').click(function() {
            $('#entrar').addClass('d-none');
            return $('#cadastrar').removeClass('d-none');
        });
    /*
        /Funções modal Login
    */


    /*
        Funções modal Cadastro
    */
        $('#formCadastro').validate({
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
                },

                repita_senha_cadastro: {
                    required: true,
                    equals: $('#senha_cadastro').val()
                }
            },

            messages: {
                usuario_cadastro: {
                    required: "Informe seu nome de usuário"
                },

                email_cadastro: {
                    required: "Informe seu e-mail"
                },

                senha_cadastro: {
                    required: "Informe sua senha"
                },

                repita_senha_cadastro: {
                    required: "Repita sua senha",
                    equals: "Senhas não coincidem"
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

        $('#formCadastro').submit(function(e) {
            e.preventDefault();

            if ($(this).valid()) {
                alert(`Bem-vindo, ${$('#nome_cadastro').val()}!`);
                return location.reload();
            }
        });

        $('#senha_cadastro').change(function() {
            return $(this).val() !== "" ? $('#repita_senha_cadastro').removeClass('d-none') : $('#repita_senha_cadastro').addClass('d-none');
        });

        $('#aPossuiConta').click(function() {
            $('#cadastrar').addClass('d-none');
            return $('#entrar').removeClass('d-none');
        });
    /*
        /Funções modal Cadastro
    */
});