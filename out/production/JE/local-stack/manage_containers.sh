#!/bin/bash

action=$1

function start_containers() {
    docker-compose up -d
}

function stop_containers() {
    docker-compose down
}

case "$action" in
    start)
        start_containers
        ;;
    stop)
        stop_containers
        ;;
    *)
        echo "Usage: ./manage_containers.sh [start|stop]"
        exit 1
        ;;
esac
