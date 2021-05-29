<script>
  import { Doughnut } from 'vue-chartjs'
  export default {
    extends: Doughnut,
    props:[
      'chartdata'
    ]
    ,
    
    data () {
      return {
        datacollection: {
          labels: ['긍정','부정'],
          datasets: [
            {
              label: '리뷰',
              backgroundColor: '#f87979',
              //pointBackgroundColor: 'white',
              //borderWidth: 1,
              //pointBorderColor: '#249EBF',
              data: this.chartdata,
              backgroundColor: [
                'rgb(255, 99, 132)',
                'rgb(54, 162, 235)',
                
              ],
              borderColor: [
                'rgb(255, 99, 132)',
                'rgb(255, 159, 64)',
                'rgb(255, 205, 86)',
                'rgb(75, 192, 192)',
                'rgb(54, 162, 235)',
                'rgb(153, 102, 255)',
                'rgb(201, 203, 207)'
              ],
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