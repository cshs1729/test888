
import java.util.*
fun cal_arr(array1:Array<Int>):Triple<Int, Int,Int>{
    array1.sort()
    var max_pair : Int =0;
    var pair_top : Int =0;
    var straight_top : Int =0;

    var before_num : Int =-1;
    var now_pair : Int =1;
    var staright_count : Int =1;
    for (i in array1) {

        if(before_num == i){
            now_pair++;}

        else if(before_num+1 == i ){
            now_pair=1;
            staright_count++; }

        else{
            now_pair=1;
            staright_count=0;
        }
        if(staright_count>=5){
            straight_top = i;
        }
        else if(now_pair>=2&&now_pair>max_pair){
            max_pair= now_pair;
            pair_top = i;
        }
        else if(now_pair>=2&&now_pair==max_pair){
            pair_top = i;
        }
        before_num=i;
    }
    return Triple(max_pair, pair_top, straight_top)
}

fun main(args: Array<String>) {

    // 깃허브 처음 사용으로 이해하는데 시간소모가 컸으며, 시간배분 문제로 완벽한 요구조건 달성 불가
    // 깃허브는 아직 제대로 숙달 못한 상태로 이후 추가학습 필요
    // 세부 요구조건(10줄 이상 별도함수) 무시 -> 일단 구현(0.1.0 버전) 우선 제출 -> 제출 이후 깃허브 정확한 이해 및 수정으로 (1.0.0버전) 되도록 노력
    // 깃허브 이해 숙달은 미루면 내일 일정에 영향을 줘서 불가하며, 오늘 중으로 해결해야할 문제

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    // array1, array2 주어짐

    // 논쟁점1 세미콜론으로 나눠진 구문도 한줄인가? -> 한줄이라는게 중론이어서 진행
    var array1 = arrayOf(9, 2, 3, 1, 3, 4, 10); var array2 = arrayOf(1, 4, 1, 3, 5, 6, 10);
    // 일단 각각 소팅
    val (max_pair_1, pair_top_1, straight_top_1) = cal_arr(array1);
    val (max_pair_2, pair_top_2, straight_top_2) = cal_arr(array2);

    if(max_pair_1==4||max_pair_2==4){
        if(pair_top_1>pair_top_2){
            println("1")
        }
        else if(pair_top_1>pair_top_2){
            println("2")
        }
        else{
            println("0")
        }
    }
    else if(straight_top_1>4||straight_top_2>4){
        if(straight_top_1>straight_top_2){
            println("1")
        }
        else if(straight_top_1<straight_top_2){
            println("2")
        }
        else{
            println("0")
        }
    }
    else if(max_pair_1>max_pair_2){
        println("1")
    }
    else if(max_pair_1<max_pair_2){
        println("2")
    }
    else if(pair_top_1>pair_top_2){
        println("1")
    }
    else if(pair_top_1<pair_top_2){
        println("2")
    }
    else{
        println("0")
    }


    println(Arrays.toString(array1))
    //println(max_pair)
    //println(" " + pair_top)
    // 2페어<3페어<연속<4페어
    // 최고 랭킹 저장과 현재상태 필요
    println("1과 10중 최댓값은 ${maxOf(1,2)}입니다.");
}
