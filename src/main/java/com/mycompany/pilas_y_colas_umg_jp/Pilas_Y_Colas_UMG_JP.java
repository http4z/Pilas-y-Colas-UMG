//Alumno: Josue Ignacio Paz Moran
//Carné: 1290-21-5213
//Curso: Programación III
//Fecha: 28/02/2023
//Carrera: Ingeniería en Sistemas - Sede Antigua Guatemala - Diario Vespertino

#include <iostream>
#include <stack>
#include <queue>
#include <random>
#include <fstream>

int main() {
  std::cout << "1. Pila\n2. Cola" << std::endl;
  std::cout << "Seleccione una opcion: ";
  int opcion;
  std::cin >> opcion;
  
  std::stack<int> pila;
  std::queue<int> cola;
  
  int min = -10000000;
  int max = 10000000;
  int cant = 1000000;
  
  std::cout << "\nGenerando..." << std::endl;
  
  std::random_device rd;
  std::mt19937 gen(rd());
  std::uniform_int_distribution<> dis(min, max);
  
  std::ofstream arch_alea("Aleatorios.txt");
  for (int i = 0; i < cant; ++i) 
  {
    int num_alea = dis(gen);
    arch_alea << num_alea << std::endl;
    if (opcion == 1) {
      pila.push(num_alea);
    } else {
      cola.push(num_alea);
    }
  }
  arch_alea.close();
  std::cout << "Hecho\n" << std::endl;
  
  std::ofstream arch_opc((opcion == 1 ? "Pila.txt" : "Cola.txt"));
  arch_opc << "Números " << (opcion == 1 ? "extraídos de la pila:" : "extraídos de la cola:") << std::endl;
  std::cout << "Extrayendo..." << std::endl;
  
  for (int i = 0; i < cant; ++i) 
  {
    int num_alea = (opcion == 1 ? pila.top() : cola.front());
    
    if (opcion == 1) {
      arch_opc << num_alea << std::endl;
      pila.pop();
    } else {
      arch_opc << num_alea << std::endl;
      cola.pop();
    }
  }
  arch_opc.close();
  
  std::cout << "Hecho" << std::endl;
  return 0;
}
