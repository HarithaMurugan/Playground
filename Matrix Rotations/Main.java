#include<iostream>
using namespace std;
int mat[1000][1000], initial[1000][1000];
void rotateMatrix(int N) 
{ 
    for (int i = 0; i < N / 2; i++) { 
        for (int j = i; j < N - i - 1; j++) { 
            int temp = mat[i][j]; 
            mat[i][j] = mat[N - 1 - j][i]; 
            mat[N - 1 - j][i] = mat[N - 1 - i][N - 1 - j]; 
            mat[N - 1 - i][N - 1 - j] = mat[j][N - 1 - i]; 
            mat[j][N - 1 - i] = temp; 
        } 
    } 
} 
  
int main(){
	int N, t = 0, r, c, x, y, z, a = 0, angle;
	cin>>N;
	char ch;
	for(int i = 0; i < N; i++){
		for(int j = 0; j < N; j++){
			cin>>mat[i][j];
			initial[i][j] = mat[i][j];
		}
	}
	while(true){
		cin>>ch;
		if(ch == 'A'){
			cin>>angle;
			t = angle / 90;
			t = t % 4;
			a = a + t;
			while(t--){
				rotateMatrix(N);
			}
		}
		else if(ch == 'Q'){
			cin>>r>>c;
			cout<<mat[r-1][c-1]<<endl;
		}
		else if(ch == 'U'){
			cin>>x>>y>>z;
			for(int i = 0; i < N; i++)
			    for(int j = 0; j < N; j++)
			        mat[i][j] = initial[i][j];
			
			mat[x-1][y-1] = z;
			while(a--){
				rotateMatrix(N);
			}
		}
		else{
			break;
		}
	}
	return 0;
}