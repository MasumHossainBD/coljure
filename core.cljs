(ns travel.core
    (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(println "This text is printed from src/demo3/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

;;(defonce app-state (atom {:text "Hello world!"}))
(defn menu[index name]
  (let [hover (reagent/atom false)]
    (fn [_]
      [:div {:on-mouse-enter #(reset! hover true)
             :on-mouse-leave #(reset! hover false)
             :style
             {
              :padding "15px 20px"
              :font-size "18px"
              :font-family "'Titillium Web', sans-serif"
              :color (if @hover
                               "#17b9b8"
                               "#000")}}
       (.toUpperCase name)])))

(defn navigation[]
  (let [height "15px"]
  [:div {
         :style{
                :position :absolute
                :width "100%"
             ;;   :height height
                }
         }
   [:div {:style {:width "100%"
                  :display :flex
                  :align-items "center"
                  :justify-content :center
                  :background-color "#fff"
                  :color "#000"}}

    [:img {
           :style {:height "100%"
                   :margin "auto 0"}
           :src " https://static.wixstatic.com/media/4938ed_c87f30d91b41450b944e1b1a61ba195b~mv2.png/v1/fill/w_231,h_33,al_c,q_80,usm_0.66_1.00_0.01/envylogosmall.webp"}]
    (map-indexed
     (fn [i v]
       [:div{:style {:color "#000"}
             :key (str "navigation" i)}
        [menu i v]])
     ["retail" "hospitality" "salons" "other    "])
    [:img {:style{:height "100%" :margin "auto 5px"}
           :src "https://static.wixstatic.com/media/4938ed_5d43f77ca59f499b9894fc07c987fd31~mv2.png/v1/fill/w_20,h_19,al_c,q_80,usm_0.66_1.00_0.01/phone2.webp"
           }]
    [:p[:b "01 691 8874"]]
    [:p {:style{:background-color "#17b9b8"
                :color "#fff"
                :padding "5px 20px"
                :margin "15px 15px"}
  }(.toUpperCase "get in touch")]]]))

(defn hello-world []
  
  
  
  [:div
 
    ;;kkkk
   ;;kkkk
   

    [navigation]
   
   [:div {:style{
               
                 :background-image "url(http://114.130.83.88/test2_files/0000%20EnvyTech%20Website%20v1%20assets-01%20EDITE.webp)"
                 :height "100vh"
                 :background-position :center
             ;;    :background-size :cover
                 :display :flex
                 :background-repeat "no-repeat"
                 :justify-content :flex-end
                 :align-items :center
                
              ;; :flex-direction :column
                 }}


    [:div{:style{:display :flex
                 :flex-direction "column"
                 :color "#fff"
                 :justify-content :flex-end
                 :line-height "0px"
                 :width "50%"
                 
                 :font-family "'Titillium Web', sans-serif"
                 :word-spacing "10px"
                 :font-size "24px"}}
     [:div
      {:style {:background-color "#000"
               :font-size "41px"}}
     
       " Affordable EPOS systems"]
     [:h1 {:style {:background-color "#fff"}} "From only €299"]]


    [:div
    
     {:style{:display :flex
             :justify-content :space-between
             :font-size "20px"
            ;; :margin-left "50px"
             }}
  
    

]

    ]]



 ) 

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
