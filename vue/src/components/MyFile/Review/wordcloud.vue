<template>
  <div>
    <cloud :data="words" :fontSizeMapper="fontSizeMapper" />
  </div>
</template>
 
<script>
import Cloud from 'vue-d3-cloud'
import http from '@/util/http-common'

export default {
    name: 'app',
    data() {
        return {
            words: [
                // { text: 'dsdsds', value: 1000 ,handlers: {
                //     click: function() {
                //     alert('dsdsdadas !');
                //     }
                // }},
                // { text: 'js', value: 200 },
                // { text: 'is', value: 800 },
                // { text: 'very cool', value: 1000000 },
                // { text: 'lunch', value: 100 },
            ],
            fontSizeMapper: word => Math.log(word.value) * 5,
        }
    },
    components: {
        Cloud,
    },
    created(){
        //console.log("실행")
        let words=[]
        http.get("/review/word").then(({data})=>{
            //console.log(data)
            
            data.forEach(item => {
                let word={
                    text:item.word,
                    value:item.count*20,
                }
                if(item.count>=40){
                    word['value']*=100
                }
                else if(item.count>=30){
                    word['value']*=70
                }
                else if(item.count>=20){
                    word['value']*=40
                }
                words.push(word)
            });
            //console.log(words)
            this.words=words
        })
    }
}
</script>

