const loginsec=document.querySelector('.login-section')
const loginlink=document.querySelector('.login-link')
const registerlink=document.querySelector('.register-link')
registerlink.addEventListener('click',()=>{
    loginsec.classList.add('active')
})
loginlink.addEventListener('click',()=>{
    loginsec.classList.remove('active')
})
document.addEventListener("DOMContentLoaded", function () {
    const loginForm = document.querySelector(".form-box.login form");

    loginForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const username = loginForm.querySelector("input[name='username']").value;
        const password = loginForm.querySelector("input[name='password']").value;
        const rememberMe = loginForm.querySelector("input[name='rememberMe']").checked;

        // Gửi dữ liệu đăng nhập đến máy chủ bằng AJAX hoặc fetch API
        // Ví dụ sử dụng fetch API:
        fetch("/LoginServlet", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: username,
                password: password,
                rememberMe: rememberMe
            })
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    // Xử lý đăng nhập thành công
                    window.location.href = "/dashboard"; // Chuyển hướng đến trang dashboard hoặc trang khác
                } else {
                    alert(data.message); // Hiển thị thông báo lỗi
                }
            })
            .catch(error => {
                console.error("Error:", error);
            });
    });
});