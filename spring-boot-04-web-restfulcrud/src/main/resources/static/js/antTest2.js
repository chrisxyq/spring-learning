var vm = new Vue({
    el: '#app',
    data: {
        formInline: {
            user: '',
            password: '',
        }
    },
    methods: {
        handleSubmit(e) {
            console.log(this.formInline);
        }
    },
})