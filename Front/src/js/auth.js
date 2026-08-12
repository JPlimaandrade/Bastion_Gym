/**
 * Autenticação - Bastion GYM
 * Arquivo: auth.js
 * Descrição: Funcionalidades de Login e Cadastro
 */

/**
 * Valida e submete formulário de login
 */
document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');
    if (loginForm) {
        loginForm.addEventListener('submit', function(e) {
            e.preventDefault();
            
            const email = document.getElementById('email');
            const password = document.getElementById('password');
            let isValid = true;
            
            // Validação de e-mail
            if (!validateEmail(email.value)) {
                email.classList.add('error');
                isValid = false;
            } else {
                email.classList.remove('error');
            }
            
            // Validação de senha
            if (password.value.length < 6) {
                password.classList.add('error');
                isValid = false;
            } else {
                password.classList.remove('error');
            }
            
            if (isValid) {
                alert('Login realizado com sucesso! (Demo)');
            }
        });
    }
    
    const cadastroForm = document.getElementById('cadastroForm');
    if (cadastroForm) {
        cadastroForm.addEventListener('submit', function(e) {
            e.preventDefault();
            
            const nome = document.getElementById('nome');
            const email = document.getElementById('email');
            const password = document.getElementById('password');
            const confirmPassword = document.getElementById('confirmPassword');
            const telefone = document.getElementById('telefone');
            let isValid = true;
            
            // Validação de nome
            if (nome.value.trim().length < 3) {
                nome.classList.add('error');
                isValid = false;
            } else {
                nome.classList.remove('error');
            }
            
            // Validação de e-mail
            if (!validateEmail(email.value)) {
                email.classList.add('error');
                isValid = false;
            } else {
                email.classList.remove('error');
            }
            
            // Validação de senha
            if (password.value.length < 6) {
                password.classList.add('error');
                isValid = false;
            } else {
                password.classList.remove('error');
            }
            
            // Validação de confirmação de senha
            if (password.value !== confirmPassword.value) {
                confirmPassword.classList.add('error');
                isValid = false;
            } else {
                confirmPassword.classList.remove('error');
            }
            
            // Validação de telefone (opcional)
            if (telefone.value.trim() !== '') {
                if (!validateTelefone(telefone.value)) {
                    telefone.classList.add('error');
                    isValid = false;
                } else {
                    telefone.classList.remove('error');
                }
            }
            
            if (isValid) {
                alert('Cadastro realizado com sucesso! (Demo)');
            }
        });
    }
});
