# [Gold III] 배열 돌리기 6 - 20327 

[문제 링크](https://www.acmicpc.net/problem/20327) 

### 성능 요약

메모리: 314132 KB, 시간: 2008 ms

### 분류

구현(implementation), 시뮬레이션(simulation)

### 문제 설명

<p>크기가 2<sup>N</sup>×2<sup>N</sup>인 배열이 있을 때, 배열에 연산을 R번 적용하려고 한다. 연산은 8가지가 있고, 연산에는 단계 ℓ (0 ≤ ℓ < N)이 있다. 단계 ℓ은 배열을 부분 배열로 나눌때 사용하는 값이며, 부분 배열의 크기는 2<sup>ℓ</sup>×2<sup>ℓ</sup>가 되어야 한다. 단계는 연산을 수행할때마다 정한다.</p>

<p>다음은 크기가 2<sup>3</sup>×2<sup>3</sup> 배열을 단계 ℓ의 값에 따라 부분 배열로 나눈 것이다. 같은 부분 배열은 같은 색상으로 표시했다.</p>

<table class="table table-bordered td-center th-center" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width:33%;"><img alt="" src="https://upload.acmicpc.net/f24cff71-7497-4787-b7f3-a9d078b34838/-/preview/" style="width: 200px; height: 201px;"></td>
			<td style="width:34%;"><img alt="" src="https://upload.acmicpc.net/b1a58aab-4244-40a9-bc79-2c94e2b2d123/-/preview/" style="width: 200px; height: 201px;"></td>
			<td style="width:33%;"><img alt="" src="" style="width: 200px; height: 201px;"></td>
		</tr>
		<tr>
			<th>ℓ = 0</th>
			<th>ℓ = 1</th>
			<th>ℓ = 2</th>
		</tr>
	</tbody>
</table>

<p>1번 연산은 각 부분 배열을 상하 반전시키는 연산이다.</p>

<table class="table table-bordered td-center th-center" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
		</tr>
		<tr>
			<th>배열</th>
			<th>ℓ = 1, 1번 연산 적용</th>
		</tr>
	</tbody>
</table>

<p>2번 연산은 각 부분 배열을 좌우 반전시키는 연산이다.</p>

<table class="table table-bordered td-center th-center" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
		</tr>
		<tr>
			<th>배열</th>
			<th>ℓ = 2, 2번 연산 적용</th>
		</tr>
	</tbody>
</table>

<p>3번 연산은 각 부분 배열을 오른쪽으로 90도 회전시키는 연산이다.</p>

<table class="table table-bordered td-center th-center" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
		</tr>
		<tr>
			<th>배열</th>
			<th>ℓ = 1, 3번 연산 적용</th>
		</tr>
	</tbody>
</table>

<p>4번 연산은 각 부분 배열을 왼쪽으로 90도 회전시키는 연산이다.</p>

<table class="table table-bordered td-center th-center" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
		</tr>
		<tr>
			<th>배열</th>
			<th>ℓ = 2, 4번 연산 적용</th>
		</tr>
	</tbody>
</table>

<p>5, 6, 7, 8번 연산은 부분 배열을 한 칸으로 생각하고 적용시킨다. 즉, 부분 배열의 안에 있는 값은 변하지 않는다.</p>

<p>5번 연산은 배열을 상하 반전시키는 연산이다.</p>

<table class="table table-bordered td-center th-center" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
		</tr>
		<tr>
			<th>배열</th>
			<th>ℓ = 2, 5번 연산 적용</th>
		</tr>
	</tbody>
</table>

<p>6번 연산은 배열을 좌우 반전시키는 연산이다.</p>

<table class="table table-bordered td-center th-center" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
		</tr>
		<tr>
			<th>배열</th>
			<th>ℓ = 1, 6번 연산 적용</th>
		</tr>
	</tbody>
</table>

<p>7번 연산은 오른쪽으로 90도 회전시키는 연산이다.</p>

<table class="table table-bordered td-center th-center" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
		</tr>
		<tr>
			<th>배열</th>
			<th>ℓ = 1, 7번 연산 적용</th>
		</tr>
	</tbody>
</table>

<p>8번 연산은 왼쪽으로 90도 회전시키는 연산이다.</p>

<table class="table table-bordered td-center th-center" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
			<td style="width:50%;"><img alt="" src="" style="width: 250px; height: 251px;"></td>
		</tr>
		<tr>
			<th>배열</th>
			<th>ℓ = 2, 8번 연산 적용</th>
		</tr>
	</tbody>
</table>

### 입력 

 <p>첫째 줄에 N, R이 주어진다. 둘째 줄부터 2<sup>N</sup>개의 줄에 배열의 원소 A[i][j]가 주어진다. i번째 줄의 j번째 정수는 A[i][j]를 의미한다.</p>

<p>다음 R개의 줄에 배열에 적용시켜야 하는 연산이 한 줄에 하나씩 주어진다. 연산은 두 정수 k, ℓ로 이루어져 있고, k번 연산을 단계 ℓ로 적용한다는 의미이다.</p>

### 출력 

 <p>입력으로 주어진 배열에 R개의 연산을 순서대로 수행한 결과를 출력한다.</p>

