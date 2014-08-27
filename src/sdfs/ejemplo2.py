import simpy
import random
#
# el carro se conduceun tiempo y tiene que llegar a cargarse de energia
# luego puede continuar conduciendo
# Debe hacer cola (FIFO) en el cargador

# name: identificacion del carro
# bcs:  cargador de bateria
# driving_time: tiempo que conduce antes de necesitar carga
# charge_duration: tiempo que toma cargar la bateria

def car(env, name, bcs, driving_time, charge_duration):
    global totalWait
    # Simulate driving to the BCS
    yield env.timeout(driving_time)
    #llega a la unidad de carga
    arrive = env.now
    
    # Request one of its charging spots
    print('%s arriving at %d' % (name, env.now))
    with bcs.request() as req:  #pedimos conectarnos al cargador de bateria
        yield req
        #empieza a cargar
        wait = env.now - arrive
        totalWait = totalWait + wait

        # Charge the battery
        print('%s starting to charge at %s tiempo espera %s' % (name, env.now, wait))
        yield env.timeout(charge_duration)
        print('%s leaving the bcs at %s' % (name, env.now))
        # se hizo release automatico del cargador bcs
   
  

#
env = simpy.Environment()  #crear ambiente de simulacion
bcs = simpy.Resource(env, capacity=2) #el cargador de bateria soporta 2 carros
                                      #a la vez
random.seed(19)
# crear los carros
for i in range(5):
    #Tiempo de carga al azar
    tc=  random.randint(1,5)
    env.process(car(env, 'Car %d' % i, bcs, 0, tc))

# correr la simulacion
totalWait = 0
env.run()
print 'Tiempo total de espera = ', totalWait, "Promedio:", totalWait/5.0
