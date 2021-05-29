<script>
  import { Line ,mixins  } from 'vue-chartjs'
  export default {
    extends: Line ,
    props:[
      'chartdata'
    ]
    ,
    mixins :[0],
    data () {
      return {
        datacollection: {
          labels: ['total','traffic','around','care','resident'],
          datasets: [
            {
              label: '리뷰',
              data: this.chartdata,
            }
          ]
        },
        options: {
          legend: {
            display: true
          },
          responsive: true,
          maintainAspectRatio: false
        }
      }
    },
    mounted () {
      this.renderChart(this.datacollection, this.options)
    }
  }
</script>