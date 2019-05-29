var app = new Vue({
    el: '#app',
    data: {
        pregs: [],
        current_preg:'',
        data:'',
        message: 'Hello Vue!',
        datos: true,
        materias: [],
        opcion: 'menu',
        materia: 'lae'
    },
    methods: {
    	fn_materia: function(){
  		  alert('hola');
  	  },
        fn_add: function () {
            this.pregs.push({desc: this.current_preg,resps:[]});
            this.current_preg=''
        },
        fn_remove_question:function(index)
        {
            console.log(index);
            this.pregs.splice(index,1)
        },
        fn_ver:function(){
            var arr=[];
            for(var i=0;i<this.pregs.length;i++){
                var index = -1;
                var resps=[];
                for(var j=0;j<this.pregs[i].resps.length;j++){
                    resps[j]=fn_clean_prepare(this.pregs[i].resps[j].desc);
                    if( this.pregs[i].resps[j].isTheRightAnswer) index=j;
                }
                arr.push(fn_clean_prepare(this.pregs[i].desc) + '¬'+ resps.join('·') + '¬' + index)
            }
            this.data=arr.join('\n');
            console.log(this.data);
            alert('Esto se mandaría al servidor\n\n'+this.data);

        }
    },
    computed:{
    }
});


Vue.component('my-hello', {
	template: `
		<h2>Estoy en my-hello</h2>
	`
});

Vue.component('my-materias', {
	template: `
		<div>
		
		<!-- Sin VUE.JS -->
		<h2>Nueva materia</h2>
		<form name="cat_form" action="/materia/nueva" method="POST">
			<div class="form-group">
				<label for="exampleInputEmail1">Nombre</label> <input type="text"
					name="nombre" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter name" required>
			</div>
			<button type="button" class="btn btn-primary" @click="fn_enviar">Enviar</button>
		</form>

		<br>

		<h3>Lista de materias</h3>
		<ul class="list-group" v-if="materias.length>0">
			<li class="list-group-item" v-for="c in materias">{{c.id}}
				{{c.nombre}}</li>
		</ul>

		<div class="alert alert-danger" role="alert" v-else>Aun no hay
			materias</div>
		
		</div>
	`,
	props: ['materias'],
	mounted: function(){
		
		console.log('Iniciando componente my-categories');
		
		axios.get('/materia/todas')
		.then(function(response) {
			this.app.materias = response.data;
			console.log(response.data);
		});
	},
	methods: {
		fn_enviar: function(){
			var fd = new FormData();
			fd.append("nombre", document.forms['cat_form'].nombre.value);
			console.log(document.forms['cat_form'].nombre.value);
			
			axios({
				method: 'post',
				url: '/materia/nueva',
				responseType: 'json',
				data: fd
			})
			.then(function(response){
				this.app.materias = response.data;
				console.log(response);
			});
		}
	}
		
});

Vue.component('my-laes', {
	template: `
		<div>
		
		<div class="box">
			<label for="preg">Pregunta</label> <input type="text" name="preg"
				size="85" v-model="current_preg" @keyup.enter="fn_add"> <input
				type="button" value="+" @click="fn_add">
		</div>
		
		<ul v-if="pregs.length>0">
			<li v-for="(preg,index) in pregs">{{preg.desc}}
				<button @click="fn_remove_question(index)">x</button> <br> <respuesta-component
					v-bind:index="index" v-bind:preg="preg"></respuesta-component>
			</li>
		</ul>
		
		</div>
	`,
	props: ['materias'],
	mounted: function(){
		
		console.log('Iniciando componente my-laes');
		
		axios.get('/materia/todas')
		.then(function(response) {
			this.app.materias = response.data;
			console.log(response.data);
		});
	},
	methods: {
		fn_enviar: function(){
			var fd = new FormData();
			fd.append("nombre", document.forms['cat_form'].nombre.value);
			console.log(document.forms['cat_form'].nombre.value);
			
			axios({
				method: 'post',
				url: '/materia/nueva',
				responseType: 'json',
				data: fd
			})
			.then(function(response){
				this.app.materias = response.data;
				console.log(response);
			});
		}
	}
		
});



Vue.component('respuesta-component',{
    template:`
    <div class="resp_block">
        <div style="padding-left: 8px">
            <label for="resp">Respuesta</label><input type="text" size="40" v-bind:id="fn_name('resp',index,-1)" v-model:value="inputText" @keyup.enter="fn_add_resp">
            <input type="checkbox" v-model="checked">Respuesta correcta
            <input type="button" value="+" @click="fn_add_resp">
        </div>
        <ul v-if="preg.resps.length>0">
            <li v-for="(resp,idx) in preg.resps">
            {{resp.desc}} <input type="radio" v-bind:id="fn_name('_r',index,idx)" v-bind:name="fn_name('_r',index,-1)" v-bind:value="idx" :checked="resp.isTheRightAnswer" @change="fn_radio_change">{{resp.isTheRightAnswer}}
            </li>
        </ul>
    </div>
    `,
    data:function(){
        return {
            inputText:'',
            checked:true,
            picked:false
        }
    },
    methods:{
        fn_add_resp: function () {
            this.preg.resps.push({desc:this.inputText,isTheRightAnswer:this.checked});
            this.checked=false;
            this.inputText=''
        },
        fn_name:function(pre,mid,pos){
            return pre+'_'+mid+(pos>=0?'_'+pos:'')
        },
        fn_radio_change:function(e){
            for(var i=0;i<this.preg.resps.length;i++){
                this.preg.resps[i].isTheRightAnswer= (i== e.target.value)
            }
        },
    },
    mounted: function () {
        document.getElementById("resp_"+this.index).focus();
    },
    props:['index','preg']
});