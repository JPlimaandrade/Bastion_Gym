/**
 * Edição de Perfil - Bastion GYM
 * Arquivo: perfil-edit.js
 * Descrição: Funcionalidades da página de edição de perfil
 */

document.addEventListener('DOMContentLoaded', function() {
    const editProfileForm = document.getElementById('editProfileForm');
    if (editProfileForm) {
        editProfileForm.addEventListener('submit', function(e) {
            e.preventDefault();
            
            // Validações básicas podem ser adicionadas aqui
            alert('Perfil atualizado com sucesso! (Demo)');
        });
    }
    
    // Preview de avatar
    const avatarInput = document.getElementById('avatarInput');
    const avatarPreview = document.querySelector('.avatar-preview');
    
    if (avatarInput && avatarPreview) {
        avatarInput.addEventListener('change', function(e) {
            const file = e.target.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = function(e) {
                    avatarPreview.innerHTML = `<img src="${e.target.result}" alt="Avatar" style="width: 100%; height: 100%; object-fit: cover; border-radius: 50%;">`;
                };
                reader.readAsDataURL(file);
            }
        });
    }
});
