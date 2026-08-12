/**
 * Funções Compartilhadas - Bastion GYM
 * Arquivo: common.js
 * Descrição: Funções utilizadas em múltiplas páginas
 */

/**
 * Alterna visibilidade da senha (mostrar/ocultar)
 * @param {string} inputId - ID do input de senha
 */
function togglePassword(inputId) {
    const input = document.getElementById(inputId);
    const button = input.nextElementSibling;
    const icon = button.querySelector('i');
    
    if (input.type === 'password') {
        input.type = 'text';
        icon.classList.remove('fa-eye');
        icon.classList.add('fa-eye-slash');
    } else {
        input.type = 'password';
        icon.classList.remove('fa-eye-slash');
        icon.classList.add('fa-eye');
    }
}

/**
 * Remove classe de erro de todos os inputs quando o usuário começa a digitar
 */
function clearErrorsOnInput() {
    document.querySelectorAll('input').forEach(input => {
        input.addEventListener('input', function() {
            this.classList.remove('error');
        });
    });
}

/**
 * Máscara de telefone brasileiro
 * Formato: (XX) XXXXX-XXXX
 * @param {HTMLInputElement} input - Elemento input do telefone
 */
function maskTelefone(input) {
    input.addEventListener('input', function(e) {
        let value = e.target.value.replace(/\D/g, '');
        
        if (value.length > 11) {
            value = value.slice(0, 11);
        }
        
        if (value.length > 0) {
            value = '(' + value;
            if (value.length > 3) {
                value = value.slice(0, 3) + ') ' + value.slice(3);
            }
            if (value.length > 10) {
                value = value.slice(0, 10) + '-' + value.slice(10);
            }
        }
        
        e.target.value = value;
    });
}

/**
 * Valida email com regex
 * @param {string} email - Email a ser validado
 * @returns {boolean} - True se válido, false caso contrário
 */
function validateEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

/**
 * Valida telefone brasileiro
 * @param {string} telefone - Telefone a ser validado
 * @returns {boolean} - True se válido, false caso contrário
 */
function validateTelefone(telefone) {
    const phoneRegex = /^\(\d{2}\)\s\d{4,5}-\d{4}$/;
    return phoneRegex.test(telefone);
}

/**
 * Abre o chat de IA (sidebar no desktop, página no mobile)
 */
function openAIChat() {
    if (window.innerWidth <= 768) {
        window.location.href = 'IAChatMobile.html';
    } else {
        const sidebar = document.querySelector('.ai-sidebar');
        const overlay = document.querySelector('.ai-sidebar-overlay');
        if (sidebar) sidebar.classList.add('active');
        if (overlay) overlay.classList.add('active');
    }
}

/**
 * Fecha o chat de IA
 */
function closeAIChat() {
    const sidebar = document.querySelector('.ai-sidebar');
    const overlay = document.querySelector('.ai-sidebar-overlay');
    if (sidebar) sidebar.classList.remove('active');
    if (overlay) overlay.classList.remove('active');
}

/**
 * Inicializa funcionalidades comuns quando o DOM estiver pronto
 */
document.addEventListener('DOMContentLoaded', function() {
    clearErrorsOnInput();
    
    // Inicializa máscara de telefone se houver input com id 'telefone'
    const telefoneInput = document.getElementById('telefone');
    if (telefoneInput) {
        maskTelefone(telefoneInput);
    }
});
