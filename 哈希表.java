#include<stdlib.h>  
#include<math.h>  
struct HashTable;  
struct ListNote;  
typedef struct HashTable *HashTbl;  
typedef struct ListNote *Position;  
typedef Position List;  
int Hash(int key,int tablesize);  
int NextPrime(int x);  
HashTbl InitalizeTable(int TableSize);  
void DestroyTable(HashTbl H);  
Position Find(int key,HashTbl H);  
void Insert(int key, HashTbl H);  
void Delete(int key,HashTbl H);  
struct HashTable{   
    int TableSize;  
    Position *TheList;  
};  
struct ListNote{  
    int element;  
    Position next;  
};  
int Hash(int key,int tablesize){  
    return key%tablesize;  
}  