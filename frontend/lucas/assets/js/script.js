$(function() {
    /*
        Funções form Login
    */
        $('#formLogin').validate({
            onsubmit: true,

            rules: {
                email_login: {
                    required: true
                },

                senha_login: {
                    required: true
                }
            },

            messages: {
                email_login: {
                    required: "Informe seu e-mail"
                },

                senha_login: {
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
                alert(`Bem-vindo, ${$('#email_login').val()}!`);
                return location.reload();
            }
        });


        $('#aCadastrarConta').click(function() {
            $('#formLogin').addClass('d-none');
            return $('#formCadastro').removeClass('d-none');
        });
    /*
        /Funções form Login
    */


    /*
        Funções form Cadastro
    */
        $('#formCadastro').validate({
            onsubmit: true,

            rules: {
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
                alert(`Bem-vindo, ${$('#email_cadastro').val()}!`);
                return location.reload();
            }
        });

        $('#senha_cadastro').change(function() {
            return $(this).val() !== "" ? $('#repita_senha_cadastro').removeClass('d-none') : $('#repita_senha_cadastro').addClass('d-none');
        });

        $('#aPossuiConta').click(function() {
            $('#formCadastro').addClass('d-none');
            return $('#formLogin').removeClass('d-none');
        });
    /*
        /Funções form Cadastro
    */
});